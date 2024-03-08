const applicantList: Applicant[] = [];

fillSkillsOptions('skillsContainer');

const input = <HTMLInputElement>document.getElementById('applicantName');
const btnDelete = document.getElementById('btnDelete');
const profileApplicant = <HTMLInputElement>document.getElementById('showApplicantProfile');
const vacancyList = <HTMLElement>document.getElementById('vacancyList');
const skillType = Object.values(Skill) as string[];
let skillsChart: Chart | null = null;

function registerApplicant() {

    const nameApplicantInput = (document.getElementById("name") as HTMLInputElement).value;
    const emailApplicantInput = (document.getElementById("email") as HTMLInputElement).value;
    const stateApplicantInput = (document.getElementById("state") as HTMLInputElement).value;
    const cepApplicantInput = (document.getElementById("cep") as HTMLInputElement).value;
    const educationApplicantInput = (document.getElementById("education") as HTMLInputElement).value;
    const descriptionApplicantInput = (document.getElementById("description") as HTMLInputElement).value;
    const ageApplicantInput = (document.getElementById("age") as HTMLInputElement).value;
    const cpfApplicantInput = (document.getElementById("cpf") as HTMLInputElement).value;
    const skillsSelect = document.querySelectorAll('#skillsContainer input[name="skills"]:checked');
    const skills = Array.from(skillsSelect, option => (option as HTMLSelectElement).value);

    const nameApplicant = validateRegex(textRegex, nameApplicantInput, "Nome");
    const emailApplicant = validateRegex(emailRegex, emailApplicantInput, "Email");
    const stateApplicant = validateRegex(textRegex, stateApplicantInput, "Estado");
    const cepApplicant = validateRegex(cepRegex, cepApplicantInput, "CEP");
    const educationApplicant = validateRegex(textRegex, educationApplicantInput, "Formação");
    const descriptionApplicant = validateRegex(textRegex, descriptionApplicantInput, "Descrição");
    const ageApplicant = parseInt(validateRegex(ageRegex, ageApplicantInput, "Idade"));
    const cpfApplicant = validateRegex(cpfRegex, cpfApplicantInput, "CPF");

    if (skills.length == 0) {
        
        alert("Preencha pelo menos uma skill.")
    }

    if (nameApplicant != '' && ageApplicant > 0 && emailApplicant != '' && cpfApplicant != '' && stateApplicant != '' && cepApplicant != '' && educationApplicant != '' && descriptionApplicant != '' && skills.length > 0) {

        const applicant = new Applicant(nameApplicant, ageApplicant, emailApplicant, cpfApplicant, stateApplicant, cepApplicant, educationApplicant, descriptionApplicant, skills);

        applicantList.push(applicant);

        alert(`Candidato Cadastrado!`);

    }
}

function searchApplicant() {
    
    const applicantName: string = input.value.toString();

    showApplicantDetails(applicantName);

}

function deleteApplicant(){

    const applicantToDelete: string = input.value.toString();

    if(profileApplicant) {

        if(btnDelete) {

            const indexToDelete = applicantList.findIndex(applicant => applicant.name === applicantToDelete);

            if(indexToDelete !== -1) {

                applicantList.splice(indexToDelete, 1);

                alert('Candidato deletado!');

            } else {

                alert('Candidato não encontrado!');

            }
        }
    }
}



function getAllVacancies(): JobVacancy[] {

    const allVacancies: JobVacancy[] = [];

    for(const company of companyList) {

        allVacancies.push(...company.vacancies);

    }

    return allVacancies;

}



