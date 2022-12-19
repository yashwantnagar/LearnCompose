package com.ynr.learncompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynr.learncompose.ui.theme.LearnComposeTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }


    private fun showMessages(userName : String, password : String){
        Toast.makeText(this, "$userName  $password", Toast.LENGTH_SHORT).show()

        val intent = Intent(this,
            MainActivity::class.java)
        startActivity(intent)

    }

    @Composable
    fun LoginScreen(){

        val userName = remember {
            mutableStateOf("")
        }

        val userPassword = remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            androidx.compose.material.Text(
                text = "Hello Again",
                color = Color.Blue,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            androidx.compose.material.Text(
                text = "Welcome",
                color = Color.Blue,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            androidx.compose.material.Text(
                text = "Back",
                color = Color.Blue,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Person")
                },
                label = {
                    androidx.compose.material.Text(text = "Username")
                },
                placeholder = {
                    androidx.compose.material.Text(text = "Enter user name")
                },
                modifier = Modifier.fillMaxWidth().
                        padding(top = 10.dp)
            )

            OutlinedTextField(
                value = userPassword.value,
                onValueChange = {
                    userPassword.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "Password")
                },
                label = {
                    androidx.compose.material.Text(text = "Password")
                },
                placeholder = {
                    androidx.compose.material.Text(text = "Enter user password")
                },
                modifier = Modifier.fillMaxWidth().
                        padding(top = 10.dp)
            )

            OutlinedButton(
                onClick = {
                showMessages(userName.value,userPassword.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp)
            ) {
                Text(text = "Login")
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview3() {
        LearnComposeTheme {
            androidx.compose.material.Surface() {
                LoginScreen()
            }
        }
    }

}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

