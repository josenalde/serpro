//Código REFATORADO para facilidade de compreensão e evitar repetir trechos

function login() {
    showLoading();
    firebase.auth().signInWithEmailAndPassword(form.email().value, form.password().value).then(response => {
        hideLoading();
        window.location.href = "pages/home/home.html";
        //console.log('success', response)
    }).catch(error => {
        hideLoading();
        alert(getErrorMessage(error));
        //alert(error.code);
        //console.log('error', error)
    }); //retorna uma PROMISE (função que promete devolver algo)
    //console.log('depois');
    //erro 400 do lado cliente
    //console.log('### window', window);
    //console.log('### window-location', window.location);
}
function getErrorMessage(error) {
    if (error.code == "auth/user-not-found") {
        return "Usuario nao encontrado";
    }
    if (error.code == "auth/wrong-password") {
        return "Senha invalida";
    }
    return error.message;
}
function register() {
    window.location.href = "pages/register/register.html";
}

function recoverPassword() {
    showLoading();
    firebase.auth().sendPasswordResetEmail(form.email().value).then(() => {
        hideLoading();
        alert('Email enviado com sucesso');
    }).catch(error => {
        hideLoading();
        alert(getErrorMessage(error));
    });
}

function onChangeEmail() {
    toggleButtonsDisable();
    toggleEmailErrors();
}

function onChangePassword() {
    toggleButtonsDisable();
    togglePasswordErrors();
}

//function validadeFields() {
//    toggleButtonsDisable();
//    toggleEmailErrors();
//    togglePasswordErrors();
    /*
    const email = document.getElementById("email").value;
    if (!email) {
        document.getElementById('recover-password-button').disabled = true;
    } else if (validateEmail(email)) {
        document.getElementById('recover-password-button').disabled = false;
    } else {
        document.getElementById('recover-password-button').disabled = true;
    }*/
//}

function isEmailValid() {
    const email = form.email().value;
    if (!email) {
        return false;
    }
    return validateEmail(email);
}

function toggleEmailErrors() {
    const email = form.email().value;
    form.emailRequiredError().style.display = email ? "none" : "block";
    form.emailInvalidError().style.display = validateEmail(email) ? "none" : "block";
}

function togglePasswordErrors() {
    const password = form.password().value;
    form.passwordRequiredError().style.display = password ? "none" : "block";
}

function toggleButtonsDisable() {
    const emailValid = isEmailValid();
    form.recoverPassword().disabled = !emailValid;

    const password = isPasswordValid();
    form.loginButton().disabled = !emailValid || !isPasswordValid;
}

function isPasswordValid() {
    const password = form.password().value;
    if (!password) {
        return false;
    }
    return true;
}

const form = {
    email: () => document.getElementById('email'),
    emailInvalidError: () => document.getElementById('email-invalid-error'),
    emailRequiredError: () => document.getElementById('email-required-error'),
    loginButton: () => document.getElementById('login-button'),
    password: () => document.getElementById('password'),
    passwordRequiredError: () => document.getElementById('password-required-error'),
    recoverPassword: () => document.getElementById('recover-password-button')
}