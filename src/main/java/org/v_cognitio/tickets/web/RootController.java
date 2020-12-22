package org.v_cognitio.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.v_cognitio.tickets.model.Subscription;
import org.v_cognitio.tickets.model.Ticket;
import org.v_cognitio.tickets.model.User;
import org.v_cognitio.tickets.model.UserTicket;
import org.v_cognitio.tickets.repository.DataJpaSubscriptionRepository;
import org.v_cognitio.tickets.repository.DataJpaTicketRepository;
import org.v_cognitio.tickets.repository.DataJpaUserRepository;
import org.v_cognitio.tickets.repository.DataJpaUserTicketRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

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

    @Autowired
    private DataJpaSubscriptionRepository subscriptionRepository;

    @GetMapping("/")
    public String root() {
        return "index";
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

    @PostMapping("/personal/edit")
    public String editUser(HttpServletRequest request) {
        User user = userRepository.get(userId);
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        String password = request.getParameter("password");
        if (!password.isBlank()) {
            user.setPassword(password);
        }
        userRepository.save(user);
        return "redirect:/personal";
    }

    @GetMapping("/shop")
    public String shop(Model model, HttpServletRequest request) {
        User user = userRepository.getWithTickets(userId);
        model.addAttribute("user", user);
        model.addAttribute("tickets", ticketRepository.getAll());
        model.addAttribute("subs", subscriptionRepository.getAll());
        return "shop";
    }

    @GetMapping("/shop/buyTicket")
    public String buyTicket(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        Ticket ticket = ticketRepository.get(ticketId);
        User user = userRepository.get(userId);
        UserTicket userTicket = new UserTicket(null, user, ticket,
                ticket.getPrice() -
                        ticket.getPrice() * user.getSubscription().getDiscount() / 100);
        userTicketRepository.save(userTicket);
        redirectAttributes.addAttribute("active", request.getParameter("active"));
        return "redirect:/shop";
    }

    @GetMapping("/shop/buySub")
    public String buySub(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        int subId = Integer.parseInt(request.getParameter("subId"));
        Subscription sub = subscriptionRepository.get(subId);
        User user = userRepository.get(userId);
        user.setSubscription(sub);
        user.setSubscriptionExpire(LocalDateTime.now().plusYears(1));
        userRepository.save(user);
        redirectAttributes.addAttribute("active", request.getParameter("active"));
        return "redirect:/shop";
    }

    @GetMapping("/about")
    public String about(Model model) {
        User user = userRepository.get(userId);
        model.addAttribute("user", user);
        return "about";
    }
}
