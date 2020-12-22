function changeTab(evt, tabName) {
    let i;

    let tabContent = document.getElementsByClassName("tabContent");
    for (i = 0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }

    let tabs = document.getElementsByClassName("tab");
    for (i = 0; i < tabs.length; i++) {
        tabs[i].classList.remove("active");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.classList.add("active");

    const urlParams = new URLSearchParams(window.location.search);
    urlParams.set("active", tabName);
    history.replaceState(null, null, "?" + urlParams.toString());
}

function selectActive() {
    const urlParams = new URLSearchParams(window.location.search);
    const active = urlParams.get("active");
    document.getElementById(active).style.display = "block";
    document.getElementById(active + "Tab").classList.add("active");
}

function goToBuy(params) {
    const urlParams = new URLSearchParams(window.location.search);
    const active = urlParams.get("active");
    window.location.href = "/tickets/shop" + params + "&active=" + active;
}