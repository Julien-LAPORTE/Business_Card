package fr.samneo.businesscard.model

import fr.samneo.businesscard.data.Jobs
import fr.samneo.businesscard.model.utils.FormattingUser.isValidEmail
import fr.samneo.businesscard.model.utils.FormattingUser.isValidFirstName
import fr.samneo.businesscard.model.utils.FormattingUser.isValidName
import fr.samneo.businesscard.model.utils.FormattingUser.isValidPhoneNumber

data class User(
    val firstName: String,
    val name: String,
    val job: Jobs,
    val phoneNumber: PhoneNumber,
    val email: Email,
) {
    init {
        require(isValidName(name)) { // Lève une exception si false
            "Le nom n'est pas valide."
        }
        require(isValidFirstName(firstName)) {
            "Le prénom n'est pas valide."
        }
    }
}

data class Email(val name: String, val domain: Domain) {
    enum class Domain (val adress: String) {
        HOTMAIL("hotmail.fr")
    }

    init {
        require(isValidEmail(name, domain.adress)) {
            "L'adresse Email n'est pas valide."
        }
    }
    fun getEmail(): String{
        return "$name@${domain.adress}"
    }
}


data class PhoneNumber(
    private val prefixe: Prefix,
    private val number: String,
) {

    enum class Prefix(val number: String) {
        FRANCE("+33")
    }

    init {
        require(isValidPhoneNumber(number)) {
            "Le numéro de téléphone n'est pas valide."
        }
    }

    fun getPhoneNumber(): String {

        val isOnNineCharacters = number.length == 9

        var phoneNumber = when (isOnNineCharacters) {
            true -> "${prefixe.number}${number[0]}"
            false -> {
                "${prefixe.number}${number[1]}"
            }
        }

        var i = when (isOnNineCharacters) {
            true -> 1
            false -> 2
        }

        while (i < number.length) {

            if (i + 1 < number.length) {
                phoneNumber += " ${number[i]}${number[i + 1]}"
                i += 2
            } else {

                phoneNumber += "${number[i]}"
                i++
            }

        }

        return phoneNumber
    }
}