package com.ynr.learncompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynr.learncompose.ui.theme.LearnComposeTheme


class HomeActivity : ComponentActivity() {

    private val listName = listOf(

        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. ",
        "We can retrieve the first and the last elements of the list without using the get() method. "

    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    RecyclerView(listName = listName)
                }
            }
        }


    }


    @Composable
    fun EachRow(listNames : String) {

        Card(
            modifier = Modifier.padding(vertical = 10.dp,
                horizontal = 10.dp),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            elevation = 5.dp,
            border = BorderStroke(0.1.dp, Color.Red)
        ){
            Row(modifier = Modifier.padding(5.dp)) {

                Image(painter = painterResource(id = R.drawable.photo),
                    contentDescription = "Image",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(10.dp)))
                        .size(100.dp)

                )

                Text(
                    text = listNames,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.Monospace
                )

            }

        }
    }


    @Composable
    fun RecyclerView(listName : List<String>){

        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .padding(top = 15.dp, bottom = 10.dp)
        ){
            
            items(10) {
                EachRow(listNames = "We can retrieve the first and the last elements of the list without using the get() method. ")
            }
            
            /*items(listName){ listNames ->
                EachRow(listNames)
            }*/
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        LearnComposeTheme {
            Surface {
                RecyclerView(listName = listName)
            }
        }
    }

}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LearnComposeTheme {
        Greeting2("Android")
    }
}*/
