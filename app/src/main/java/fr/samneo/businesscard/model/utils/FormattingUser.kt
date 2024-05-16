package fr.samneo.businesscard.model.utils

object FormattingUser {

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.isNotBlank() && phoneNumber.all { it.isDigit() } && (phoneNumber.length == 9 || (phoneNumber.length == 10 && phoneNumber[0] == '0'))
    }

    fun isValidEmail(name: String, domain: String): Boolean {
        val email = "$name@$domain"
        val emailRegex = Regex("""^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$""")
        return email.matches(emailRegex)
    }

    fun isValidName(name: String): Boolean {
        return name.isNotBlank() && name.all { it.isLetter() }
    }

    fun isValidFirstName(firstName: String): Boolean {
        return firstName.isNotBlank() && firstName.all { it.isLetter() }
    }
}