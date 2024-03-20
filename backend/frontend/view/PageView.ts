function showAlert(message: string) {

    alert(message);
    
}

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

document.addEventListener('DOMContentLoaded', () => {

    const btnGenerateChart = document.querySelector('#btnSkillChart') as HTMLButtonElement;

    if (btnGenerateChart) {

        btnGenerateChart.addEventListener('click', () => {

            generateChart(applicantList);

        });
    }
});

function generateChart(applicantList: { name: string; skills: string[] }[]) {

    const labels = skillType;

    const count: number[] = labels.map(skill =>
        applicantList.filter(applicant => applicant.skills.includes(skill)).length);

    const context = document.getElementById('skillsChart') as HTMLCanvasElement | null;

    if (context) {

        if (skillsChart) {
            skillsChart.destroy();
        }

        const data = {

            labels: labels,
            datasets: [{
                label: 'Skills dos Candidatos',
                data: count,
                legend: {
                    labels: {
                        color: 'black',
                    },
                },
            }],
        }


        skillsChart = new Chart(context, {
            type: 'bar',
            data: data,
        });
    };
}