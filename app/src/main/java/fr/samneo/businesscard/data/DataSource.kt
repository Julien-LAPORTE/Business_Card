package fr.samneo.businesscard.data

import androidx.annotation.StringRes
import fr.samneo.businesscard.R
import fr.samneo.businesscard.model.Email
import fr.samneo.businesscard.model.PhoneNumber
import fr.samneo.businesscard.model.User

enum class Jobs(@StringRes val fullName: Int) {
    ANDROID_DEV(R.string.dev_android)
}

class DataSource {
    object Users {
        val primaryUser: User = User(
            firstName = "Julien",
            name = "LAPORTE",
            job = Jobs.ANDROID_DEV,
            phoneNumber = PhoneNumber(
                prefixe = PhoneNumber.Prefix.FRANCE, number = "606791645"
            ),
            email = Email(name = "julien.laporte", domain = Email.Domain.HOTMAIL),
        )
    }
}