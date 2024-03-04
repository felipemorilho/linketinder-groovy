const companyList: Company[] = [];

fillSkillsOptions('skillsContainer2');

const inputCompany = <HTMLInputElement>document.getElementById('companyName');
const showCompany = <HTMLInputElement>document.getElementById('showCompanyProfile');
const applicantRegistered = <HTMLInputElement>document.getElementById('applicantRegistered');
const btnDeleteCompany = document.getElementById('btnDeleteCompany');

document.getElementById('btnShowCompany')?.addEventListener('click', () => {

    clearHTML(applicantRegistered);

})

function registerCompany() {

    const name = (document.getElementById("nameCompany") as HTMLInputElement).value;
    const email = (document.getElementById("emailCompany") as HTMLInputElement).value;
    const cnpj = (document.getElementById("cnpjCompany") as HTMLInputElement).value;
    const state = (document.getElementById("stateCompany") as HTMLInputElement).value;
    const country = (document.getElementById("countryCompany") as HTMLInputElement).value;
    const cep = (document.getElementById("cepCompany") as HTMLInputElement).value;
    const description = (document.getElementById("descriptionCompany") as HTMLInputElement).value;

    if (name != '' && email != '' && cnpj != '' && state != '' && country != '' && cep != '' && description != '') {

        const company = new Company(name, email, cnpj, state, country, cep, description);

        companyList.push(company);

        alert(`Empresa Cadastrada: ${company.name}!`);

    } else {

        alert("Todos campos devem ser preenchidos!");

    }
}

function registerJobVacancy() {

    const jobTitle = (document.getElementById("jobTitle") as HTMLInputElement).value;
    const jobDescription = (document.getElementById('jobDescription') as HTMLInputElement).value;
    const skillsSelectJob = document.querySelectorAll('#skillsContainer2 input[name="skills"]:checked');
    const skillsJob = Array.from(skillsSelectJob, option => (option as HTMLSelectElement).value);
    const companyName: string = inputCompany.value.toString();

    const companyJob = findCompanyByName(companyName);

    if (companyJob) {

        if (jobTitle != '' && jobDescription != '' && skillsJob.length > 0) {

            companyJob.addVacancy(jobTitle, jobDescription, skillsJob)

            alert(`Vaga cadastrada na empresa ${companyName}`);

        }

    } else {

        alert('O nome da empresa deve ser digitado!')

    }
}

function searchCompany() {

    const companyName: string = inputCompany.value.toString();

    showCompanyDetails(companyName);

}

function deleteCompany() {

    const companyToDelete: string = inputCompany.value.toString();

    if(showCompany) {

        if(btnDeleteCompany) {

            const indexToDelete = companyList.findIndex(company => company.name === companyToDelete);

            if(indexToDelete !== -1) {

                companyList.splice(indexToDelete, 1);

                alert('Empresa deletada!');

            } else {

                alert('Empresa não encontrada!');

            }
        }
    }
}

function showCompanyDetails(name: string): void {

    const company = findCompanyByName(name);

    showCompany.innerHTML = '';

    if (company) {

        const title = document.createElement('h2');
        title.textContent = "Perfil: "
        showCompany.appendChild(title);

        const dataList = document.createElement('ul');

        const name = document.createElement('li');
        name.textContent = ` Nome: ${company.name}`;
        dataList.appendChild(name);

        const email = document.createElement('li');
        email.textContent = ` Email: ${company.email}`;
        dataList.appendChild(email);

        const cnpj = document.createElement('li');
        cnpj.textContent = ` Idade: ${company.cnpj}`;
        dataList.appendChild(cnpj);

        const state = document.createElement('li');
        state.textContent = ` Estado: ${company.state}`;
        dataList.appendChild(state);

        const country = document.createElement('li');
        country.textContent = ` Estado: ${company.country}`;
        dataList.appendChild(country);

        const cep = document.createElement('li');
        cep.textContent = ` CEP: ${company.cep}`;
        dataList.appendChild(cep);

        const description = document.createElement('li');
        description.textContent = ` Descrição: ${company.description}`;
        dataList.appendChild(description);

        dataList.style.listStyleType = 'none';

        showCompany.appendChild(dataList);

    } else {
        
        alert('Empresa não encontrada');

    }
}

function showApplicantRegistered() {

    const registeredApplicants = document.getElementById('applicantRegistered');

    if(registeredApplicants) {

        registeredApplicants.innerHTML = '';

        applicantList.forEach((applicant, index) => {
            
            const applicantTitle = document.createElement('h2');
            applicantTitle.textContent = `Candidato: ${index + 1}`;
            registeredApplicants.appendChild(applicantTitle);

            const skillsTitle = document.createElement('h3');
            skillsTitle.textContent = 'Skills: ';
            registeredApplicants.appendChild(skillsTitle);

            const skillList = document.createElement('ul');
            applicant.skills.forEach(skill => {

                const skillItem = document.createElement('li');
                skillItem.textContent = skill;
                skillList.appendChild(skillItem);

            });

            registeredApplicants.appendChild(skillList);

            const education = document.createElement('h3');
            education.textContent = `Education: ${applicant.education}`;
            registeredApplicants.appendChild(education);

        });
    }

}

function findCompanyByName(name: string) {
    return companyList.find(company => company.name === name);
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
