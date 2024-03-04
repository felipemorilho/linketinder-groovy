function showDiv(id: string) {

    hideAllDiv();

    const divToShow = <HTMLElement>document.getElementById(id);

    if(divToShow) {

        divToShow.style.display = 'flex';

    }
}

function hideAllDiv() {

    const allDiv = document.querySelectorAll('.hidden-div');

    allDiv.forEach((div) => {

        const hiddenDiv = <HTMLElement>div;
        hiddenDiv.style.display = 'none';

    });
}

function clearHTML(container: HTMLElement) {

    container.innerHTML = '';

}

function clearInputField() {

    const inputElements = document.querySelectorAll('input');

    inputElements.forEach((input: HTMLInputElement) => {

        if(!document.getElementById('skillsContainer') || !document.getElementById('skillsContainer2')) {
        
            input.value = '';
            
        }
    });
}