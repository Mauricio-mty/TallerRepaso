package com.monty.reforce.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.monty.reforce.ui.data.Data
import com.monty.reforce.ui.data.Info


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun viewListUsers(){

    var name: MutableState<String> = remember { mutableStateOf("") }
    var lastName by  remember { mutableStateOf("")}
    var birthdate:MutableState<String> = remember { mutableStateOf("")}
    var nickname:MutableState<String> = remember { mutableStateOf("")}
    var open = remember{ mutableStateOf(false) }
    var selectedDate = remember { mutableStateOf(LocalDate.now())}
    val infoClass = remember { mutableListOf( Data) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Gray),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

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
                    open.value=false


                },
            )
        }

        TextField(
            value = lastName,
            onValueChange = {lastName = it},
            label={Text("Apellidos")}
        )

        Spacer(modifier = Modifier.size(15.dp))

        TextField(
            value = name.value,
            onValueChange = {name.value = it},
            label={Text("Nombre")}
        )

        Spacer(modifier = Modifier.size(15.dp))

        TextField(
            modifier = Modifier.clickable {
                open.value=true
            },
            enabled = false,
            value = selectedDate.value.format(DateTimeFormatter.ISO_DATE) ,
            onValueChange = {},
            label={Text("Fecha nacimiento")}
        )

        Spacer(modifier = Modifier.size(15.dp))
        TextField(
            value = nickname.value,
            onValueChange = {nickname.value = it},
            label={Text("Apodo")}
        )
        Spacer(modifier = Modifier.size(8.dp))
        Row{

            Button(
                onClick = {
                    Data.add(Info(name.value,lastName,birthdate.value,nickname.value))
                    name.value=""
                    birthdate.value=""
                    lastName=""
                    nickname.value=""
                }
            ) {
                Text("Capturar datos")
            }
            Spacer(modifier = Modifier.size(3.dp))
            Button(
                onClick = {
                      println(infoClass)

                }
            ) {
                Text("Mostrar lista")
            }
        }


    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun prevView(){
    viewListUsers()
}