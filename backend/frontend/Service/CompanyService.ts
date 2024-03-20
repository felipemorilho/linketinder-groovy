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

    const nameInput = (document.getElementById("nameCompany") as HTMLInputElement).value;
    const emailInput = (document.getElementById("emailCompany") as HTMLInputElement).value;
    const cnpjInput = (document.getElementById("cnpjCompany") as HTMLInputElement).value;
    const stateInput = (document.getElementById("stateCompany") as HTMLInputElement).value;
    const countryInput = (document.getElementById("countryCompany") as HTMLInputElement).value;
    const cepInput = (document.getElementById("cepCompany") as HTMLInputElement).value;
    const descriptionInput = (document.getElementById("descriptionCompany") as HTMLInputElement).value;
    
    const companyName = validateRegex(textRegex, nameInput, "Nome");
    const companyEmail = validateRegex(emailRegex, emailInput, "Email");
    const companyCnpj = validateRegex(cnpjRegex, cnpjInput, "CNPJ");
    const companyState = validateRegex(textRegex, stateInput, "Estado");
    const companyCountry = validateRegex(textRegex, countryInput, "País");
    const companyCep = validateRegex(cepRegex, cepInput, "CEP");
    const companyDescription = validateRegex(textRegex, descriptionInput, "Descrição");

    if (companyName != '' && companyEmail != '' && companyCnpj != '' && companyState != '' && companyCountry != '' && companyCep != '' && companyDescription != '') {

        const company = new Company(companyName, companyEmail, companyCnpj, companyState, companyCountry, companyCep, companyDescription);

        companyList.push(company);

        showAlert(`Empresa ${company.name} Cadastrada!`);

    } 
}

function registerJobVacancy() {

    const jobTitleInput = (document.getElementById("jobTitle") as HTMLInputElement).value;
    const jobDescriptionInput = (document.getElementById("jobDescription") as HTMLInputElement).value;
    const skillsSelectJob = document.querySelectorAll('#skillsContainer2 input[name="skills"]:checked');
    const skillsJob = Array.from(skillsSelectJob, option => (option as HTMLSelectElement).value);
    const companyNameField: string = inputCompany.value.toString();

    const jobTitle = validateRegex(textRegex, jobTitleInput, "Título da vaga");
    const jobDescription = validateRegex(textRegex, jobDescriptionInput, "Descrição da vaga");

    if (skillsJob.length == 0) {
        
        showAlert("Preencha pelo menos uma skill.")

    }
    
    const companyJob = findCompanyByName(companyNameField);
    
    if (companyJob) {

        if (jobTitle != '' && jobDescription != '' && skillsJob.length > 0) {

            companyJob.addVacancy(jobTitle, jobDescription, skillsJob)

            showAlert(`Vaga cadastrada na empresa ${companyNameField}`);

        }

    } else {

        showAlert('O nome da empresa deve ser digitado!')

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

                showAlert('Empresa deletada!');

            } else {

                showAlert('Empresa não encontrada!');

            }
        }
    }
}