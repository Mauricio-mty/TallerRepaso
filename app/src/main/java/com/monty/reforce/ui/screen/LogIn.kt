package com.monty.reforce.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import com.monty.reforce.ui.theme.Backl
import androidx.compose.material3.Scaffold

import androidx.compose.foundation.clickable
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
//import com.thisisthetime.customdatepicker.ui.theme.CustomdatepickerTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.maxkeppeker.sheets.core.icons.LibIcons


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CustomDatePicker() {
    val selectedDate = remember { mutableStateOf(LocalDate.now())}
val open = remember{ mutableStateOf(false) }


    if (open.value) {
        CalendarDialog(
            state = rememberUseCaseState(visible = true, true, onCloseRequest = { } ),
            config = CalendarConfig(
                yearSelection = true,
                style = CalendarStyle.MONTH,
            ),
            selection = CalendarSelection.Date(
                selectedDate = selectedDate.value
            ) { newDate ->
                selectedDate.value = newDate
            },
        )
    }
    TextField(
        modifier =Modifier.clickable { open.value = true },
        enabled = false,
        value = selectedDate.value.format(DateTimeFormatter.ISO_DATE) ,
        onValueChange = {},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            disabledTextColor = MaterialTheme.colorScheme.onSurface,
            disabledBorderColor = MaterialTheme.colorScheme.outline,
            disabledPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant)

    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LogIn(){

  /*  Column (
        modifier = Modifier
            .background(Color.Yellow)
           .padding(3.dp)
            .border(2.dp, Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    )
    {
        Text("Yo soy Monty")
        Text("Soy Mauricio")
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
         ){
            Text(text = "1")
            Text(text = "1")
            Text(text = "1")
            Text(text = "1")
        }
        Row(
           // verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "2")
            Text(text = "2")
            Text(text = "2")
            Text(text = "2")
            Text(text = "2")
        }

    }*/

  /* Scaffold(
       topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.Black,
                ),
               title = {
               Text(text = "inicio")
               }
           )
       }
   ){

   }*/

  /*  Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.


                """.trimIndent(),
            )
        }
    }*/





}
/*
@Preview
@Composable
fun App(){
    Wha_Top ()
}*/


@Composable
fun Wha_Top (){
   Column(
       modifier = Modifier
           .background(Color.Blue),

       ){

       Row(){
           Text(text = "WhatsApp")
           Spacer(
               modifier = Modifier
                   .weight(1f)
           )
           Text(text = "F")
           Text("S")
           Text(text ="Op")
       }
   }

}

@Composable
fun Chats(){

}