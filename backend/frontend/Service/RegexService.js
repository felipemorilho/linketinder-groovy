"use strict";
const textRegex = /^[\wÁ-û\s]{3,}$/;
const emailRegex = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/i;
const cnpjRegex = /\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2}/;
const cepRegex = /\d{5}-\d{3}/;
const ageRegex = /^[1-9]\d{0,1}$/;
const cpfRegex = /\d{3}\.\d{3}\.\d{3}-\d{2}/;
function validateRegex(regexValidation, fieldToValidate, showFieldName) {
    if (regexValidation.test(fieldToValidate)) {
        return fieldToValidate;
    }
    else {
        alert(`O campo ${showFieldName} é inválido!`);
        return '';
    }
}
