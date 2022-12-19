package com.ynr.learncompose

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynr.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LearnComposeTheme {

                Surface(modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background) {

//                    NextActivity()
//                    MessageCard(Message("Android","Jetpack Compose"))

//                    Next()

                    Demo()
                    
                }


            }


        }


    }


}


@Composable
fun openURL() {

    // in the below line, we are
    // creating variables for URL
    val url = remember {
        mutableStateOf(TextFieldValue())
    }


    // on below line we are creating
    // a variable for a context
    val ctx = LocalContext.current

    // on the below line we are creating a column
    Column(
        // on the below line we are specifying modifier
        // and setting max height and max width
        // for our column
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            // on below line we are
            // adding padding for our column
            .padding(5.dp),
        // on below line we are specifying horizontal
        // and vertical alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Combine Text and Image in Button",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        // on below line adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line adding a button to open URL
        Button(onClick = {
            Toast.makeText(ctx, "Welcome to Geeks for Geeks", Toast.LENGTH_SHORT).show()
        }) {
            Column(
                // on below line we are specifying modifier
                // and setting max height and max width
                // for our column
                modifier = Modifier
                    // on below line we are
                    // adding padding for our column
                    .padding(5.dp),
                // on the below line we are specifying horizontal
                // and vertical alignment for our column
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    // on below line we are specifying the drawable
                    // image for our image.
                    painter = painterResource(id = R.drawable.ic_launcher_background),

                    // on below line we are specifying
                    // content description for our image
                    contentDescription = "Image",

                    // on below line we are setting height
                    // and width for our image.
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)

                )
                // adding spacer on below line.
                Spacer(Modifier.height(10.dp))

                // adding text on below line.
                Text(
                    // specifying text as android
                    "Android",

                    // on below line adding style
                    style = TextStyle(fontWeight = FontWeight.Bold),

                    // adding text align on below line.
                    textAlign = TextAlign.Center,

                    // adding font size on below line.
                    fontSize = 20.sp
                )

            }
        }
    }
}


@Composable
fun Demo(){

    val context = LocalContext.current

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "Home",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )
                },navigationIcon = {
                    IconButton(onClick = { showMessage(context,"Menu") }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { showMessage(context,"Notification") }) {
                        Icon(Icons.Filled.Notifications, contentDescription = "Notification")
                    }
                    IconButton(onClick = { showMessage(context,"Search") }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }

                }
            )
        },
        floatingActionButton = {

            FloatingActionButton(

                modifier = Modifier.padding(5.dp),
                onClick = {
                val intent = Intent(context,HomeActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }

        }
    ) { it

        Text(
            "Android Developer",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
        )

        
    }

}

fun showMessage(context: Context,message : String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}






@Preview(showBackground = true, name = "Light mode")
@Preview(showBackground = true, name = "dark mode",
uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    LearnComposeTheme {

        Surface {

            Demo()

//            NextActivity()

            /* MessageCard(Message("Yashwant",
                 "This is my Jetpack Compose")
             )*/

        }

    }
}

@Composable
fun NextActivity(modifier : Modifier = Modifier){

    val context = LocalContext.current

    val textValue = remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        Surface(modifier.padding(start = 15.dp, end = 15.dp)) {

            OutlinedTextField(value = textValue.value,
                onValueChange = {textValue.value = it} ,
                placeholder = {
                    Text(text = "Enter user name",
                        modifier
                            .padding(all = 5.dp)
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.subtitle2,
                        fontFamily = FontFamily.SansSerif,
                        maxLines = 1,
                        fontSize = (18.sp),
                    )
                },


            )

        }

        
        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            val intent = Intent(context,HomeActivity::class.java)
            context.startActivity(intent)
        },
            modifier
                .padding(all = 12.dp)
                .clip(shape = RoundedCornerShape(45.dp))) {
            Text(text = "Next Activity", modifier
                .align(alignment = CenterVertically)
                .padding(all = 5.dp))
        }


    }

  
}




data class Message(val title : String, val body : String)


@Composable
fun MessageCard(msg : Message,
                modifier: Modifier = Modifier,
                names : List<String> = List(10) { "$it" }

){


    
    Row (
       modifier = Modifier
           .background(Color.White)
           .padding(
               top = 18.dp,
               start = 10.dp,
               end = 10.dp,
               bottom = 10.dp
           )
           .fillMaxWidth()){

        Image(
            painter = painterResource(R.drawable.photo),
            contentDescription = "Demo",
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(
                    1.5.dp, MaterialTheme.colors.secondary,
                    CircleShape
                )
                .padding(3.dp),
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column{

            Surface() {

                Text(text = "Hello ${msg.title} ",
                    modifier = Modifier.padding(all = 4.dp),
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )

            }


            Spacer(modifier = Modifier.height(3.dp))

            Surface(shape = MaterialTheme.shapes.medium,
                elevation = 1.dp) {

                Text(text = "Hello ${msg.body}",
                    modifier = Modifier.padding(all = 5.dp),
                    style = MaterialTheme.typography.body2
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {}) {

                Text(text = "show more",
                style = MaterialTheme.typography.button
                )

            }
        }

    }

    /*Spacer(modifier = Modifier.height(8.dp))

    LazyColumn(modifier = modifier.padding(vertical = 4.dp)){
        items(items = names) { name ->
            Greeting(name = name)
        }
    }*/

}

@Composable
fun Greeting(name: String) {

    Text(text = "Hello $name",
        Modifier
            .background(Color.White)
            .padding(8.dp),
    color = Color.Blue,
    fontFamily = FontFamily.Monospace,
        fontSize = TextUnit.Unspecified
    )

}







