package fr.samneo.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.samneo.businesscard.data.DataSource
import fr.samneo.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Card(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Card(modifier: Modifier = Modifier) {
    val user = DataSource.Users.primaryUser

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Logo(
            picture = R.drawable.android_logo,
            title = "android",
            backgroundColor = Color.Black,
            modifier = Modifier.size(dimensionResource(id = R.dimen.card_logo_size))
        )
        FullNameAndJobName(
            firstName = user.firstName,
            name = user.name,
            jobName = stringResource(id = user.job.fullName)
        )
        Spacer(modifier = Modifier.weight(1f))
        FullContactInformation(
            phoneNumber = user.phoneNumber.getPhoneNumber(), email = user.email.getEmail()
        )


    }
}

@Composable
fun Logo(
    @DrawableRes picture: Int,
    title: String, backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Surface(modifier, color = backgroundColor) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(painter = painterResource(id = picture), contentDescription = "null")
            Text(text = title)
        }
    }
}

@Composable
fun FullNameAndJobName(
    firstName: String, name: String, jobName: String, modifier: Modifier = Modifier
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$firstName $name", style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = jobName, style = MaterialTheme.typography.displaySmall.copy(
                Color(0xFF3ddc84), shadow = Shadow(Color.LightGray, Offset(10f, 10f))
            )
        )
    }
}

@Composable
fun FullContactInformation(phoneNumber: String, email: String, modifier: Modifier = Modifier) {
    val style = MaterialTheme.typography.bodySmall
    val textModifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
    val iconModifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_small))
    val textAlign = TextAlign.Center

    Row {
        Spacer(Modifier.weight(1f))
        Column(
            modifier,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = null,
                    modifier = iconModifier
                )
                Text(
                    text = phoneNumber,
                    style = style,
                    modifier = textModifier,
                    textAlign = textAlign
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    modifier = iconModifier
                )
                Text(email, style = style, modifier = textModifier, textAlign = textAlign)
            }
        }
        Spacer(Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    BusinessCardTheme {
        Card()
    }
}

@Preview
@Composable
fun LogoPreview() {
    Logo(picture = R.drawable.android_logo, title = "android", backgroundColor = Color.Black)
}

@Preview(widthDp = 600)
@Composable
fun FullNameAndJobNamePreview() {
    FullNameAndJobName(
        firstName = DataSource.Users.primaryUser.firstName,
        name = DataSource.Users.primaryUser.name,
        jobName = stringResource(id = R.string.dev_android)
    )
}

@Preview(widthDp = 600)
@Composable
fun FullContactInformationPreview() {
    FullContactInformation(
        phoneNumber = DataSource.Users.primaryUser.phoneNumber.getPhoneNumber(),
        email = DataSource.Users.primaryUser.email.getEmail()
    )
}