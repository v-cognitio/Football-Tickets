package org.v_cognitio.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.v_cognitio.tickets.model.Ticket;
import org.v_cognitio.tickets.model.User;
import org.v_cognitio.tickets.model.UserTicket;
import org.v_cognitio.tickets.repository.DataJpaTicketRepository;
import org.v_cognitio.tickets.repository.DataJpaUserRepository;
import org.v_cognitio.tickets.repository.DataJpaUserTicketRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    // temporary until real auth
    private int userId;

    @Autowired
    private DataJpaUserRepository userRepository;

    @Autowired
    private DataJpaUserTicketRepository userTicketRepository;

    @Autowired
    private DataJpaTicketRepository ticketRepository;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/userTickets")
    public String getUserTickets(Model model) {
        model.addAttribute("tickets", ticketRepository.getAll());
        model.addAttribute("userTickets", userRepository.getWithTickets(
                userId).getTickets());

        return "userTickets";
    }

    @PostMapping("/personal")
    public String setUser(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userRepository.getByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            userId = user.getId();
            return "redirect:personal";
        }

        return "redirect:/";
    }

    @GetMapping("/personal")
    public String personal(Model model) {
        User user = userRepository.getWithTickets(userId);
        model.addAttribute("user", user);
        model.addAttribute("userTickets", userRepository.getWithTickets(
                userId).getTickets());
        return "personal";
    }

    @GetMapping("/personal/return")
    public String returnTicket(HttpServletRequest request) {
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        userTicketRepository.delete(ticketId);
        return "redirect:/personal";
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        User user = userRepository.getWithTickets(userId);
        model.addAttribute("user", user);
        model.addAttribute("tickets", ticketRepository.getAll());
        return "tickets";
    }

    @GetMapping("/tickets/buy")
    public String buyTicket(HttpServletRequest request) {
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        Ticket ticket = ticketRepository.get(ticketId);
        User user = userRepository.get(userId);
        UserTicket userTicket = new UserTicket(null, user, ticket,
                ticket.getPrice() -
                        ticket.getPrice() * user.getSubscription().getDiscount() / 100);
        userTicketRepository.save(userTicket);
        return "redirect:/tickets";
    }

}
