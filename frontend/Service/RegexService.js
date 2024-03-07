"use strict";
function validateRegex(regexValidation, fieldToValidate, showFieldName) {
    if (regexValidation.test(fieldToValidate)) {
        return fieldToValidate;
    }
    else {
        alert(`O campo ${showFieldName} é inválido!`);
        return '';
    }
}
