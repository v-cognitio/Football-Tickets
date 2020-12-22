let button = document.getElementById("showExitModal");
let exitModal = document.getElementById("exitModal");
let enabled = false
button.onclick = function() {
    if (!enabled) {
        exitModal.style.visibility = "visible";
        exitModal.style.opacity = "1";
    } else {
        exitModal.style.visibility = "hidden";
        exitModal.style.opacity = "0";
    }
    enabled = !enabled;
}

let exit = document.getElementById("exit");
exit.onclick = function() {
    window.location.href = "/tickets";
}

button = document.getElementById("edit");
let editModal = document.getElementById("editModal");
button.onclick = function() {
    editModal.style.display = "flex";
    exitModal.style.visibility = "hidden";
    exitModal.style.opacity = "0";
}