package fr.samneo.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    BusinessCardWindow(Modifier.padding(top = 52.dp, bottom = 52.dp))
                }
            }
        }
    }
}

@Composable
fun BusinessCardWindow(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxHeight().offset(y = -116.dp), Arrangement.Center, Alignment.CenterHorizontally
    ) {
        Logo()
        NameAndJobText(Modifier.padding(start = 48.dp, end = 48.dp, top = 16.dp, bottom = 16.dp))
    }
    Column(
        modifier.fillMaxHeight(), Arrangement.Bottom, Alignment.CenterHorizontally
    ) { ContactDetails() }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Image(
        image, null,
        Modifier
            .background(Color.Black)
            .size(116.dp)
    )
}

@Composable
fun NameAndJobText(modifier: Modifier = Modifier) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$FIRST_NAME $NAME", fontSize = 32.sp)
        Text(
            stringResource(id = R.string.job_function),
            color = colorResource(id = R.color.first_color)
        )
    }
}

@Composable
fun ContactDetails(modifier: Modifier = Modifier) {

    val emailIcon = painterResource(id = R.drawable.baseline_email_black_24)
    val phoneNumberIcon = painterResource(id = R.drawable.baseline_phone_black_24)
    val firstColor = colorResource(id = R.color.first_color)
    val iconModifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 16.dp)
    val textModifier = Modifier.padding(top = 8.dp, bottom = 8.dp)

    Column(modifier, Arrangement.Bottom, Alignment.Start) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(phoneNumberIcon, null, iconModifier, firstColor)
            Text(PHONE_NUMBER, textModifier)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(emailIcon, null, iconModifier, firstColor)
            Text(EMAIL, textModifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardWindowPreview() {
    BusinessCardTheme {
        BusinessCardWindow()
    }
}

@Preview(showBackground = true)
@Composable
fun LogoPreview() {
    Logo()
}

@Preview
@Composable
fun NameAndJobTextPreview() {
    NameAndJobText()
}

@Preview
@Composable
fun ContactDetailsPreview(modifier: Modifier = Modifier) {
    ContactDetails()
}