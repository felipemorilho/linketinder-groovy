"use strict";
function showDiv(id) {
    hideAllDiv();
    const divToShow = document.getElementById(id);
    if (divToShow) {
        divToShow.style.display = 'flex';
    }
}
function hideAllDiv() {
    const allDiv = document.querySelectorAll('.hidden-div');
    allDiv.forEach((div) => {
        const hiddenDiv = div;
        hiddenDiv.style.display = 'none';
    });
}
function clearHTML(container) {
    container.innerHTML = '';
}
function clearInputField() {
    const inputElements = document.querySelectorAll('input');
    inputElements.forEach((input) => {
        if (!document.getElementById('skillsContainer') || !document.getElementById('skillsContainer2')) {
            input.value = '';
        }
    });
}
