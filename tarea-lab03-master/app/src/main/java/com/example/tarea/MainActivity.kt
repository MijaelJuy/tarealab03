package com.example.tarea
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llamada a la función que deseas probar
            Column {
                LazyColumnExample()
                LazyRowExample()
                GridExample()
                ScaffoldExample()
                SurfaceExample()
                FlowRowExample()
                FlowColumnExample()
                AlertDialogExample()
                CardExample()
                CheckboxExample()
                FloatingActionButtonExample()
                IconExample()
                ProgressBarExample()
                RadioButtonExample()
                SliderExample()
                SpacerExample()
                SwitchExample()
                TopAppBarExample()
                BottomNavigationExample()
                DialogExample()
                DividerExample()
                DropDownMenuExample()
                LazyVerticalGridExample()
                NavigationRailExample()
                OutlinedTextFieldExample()
                PagerExample()
                SnackbarExample()
                TabRowExample()
            }
        }
    }

    // Contenedores
    @Composable
    fun LazyColumnExample() {
        LazyColumn {
            items(10) { index ->
                Text("Item #$index", modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun LazyRowExample() {
        LazyRow {
            items(10) { index ->
                Text("Item #$index", modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun GridExample() {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(10) { index ->
                Text("Item #$index", modifier = Modifier.padding(8.dp))
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldExample() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Scaffold Example") }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /* Acción */ }) {
                    Text("+")
                }
            },
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    Text("Content goes here", modifier = Modifier.padding(16.dp))
                }
            }
        )
    }

    @Composable
    fun SurfaceExample() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            color = MaterialTheme.colorScheme.primary
        ) {
            Text("Surface Example", modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun FlowRowExample() {
        Column {
            repeat(3) {
                Row(modifier = Modifier.padding(8.dp)) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Item")
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun FlowColumnExample() {
        Row {
            repeat(3) {
                Column(modifier = Modifier.padding(8.dp)) {
                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Item")
                        }
                    }
                }
            }
        }
    }

    // Controles
    @Composable
    fun AlertDialogExample() {
        var showDialog by remember { mutableStateOf(false) }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Dialog Title") },
                text = { Text("This is an example of an AlertDialog.") },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }
    }

    @Composable
    fun CardExample() {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Card Title", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Card content goes here.")
            }
        }
    }

    @Composable
    fun CheckboxExample() {
        var checked by remember { mutableStateOf(false) }

        Row(modifier = Modifier.padding(16.dp)) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Check me")
        }
    }

    @Composable
    fun FloatingActionButtonExample() {
        FloatingActionButton(
            onClick = { /* Acción */ },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("+")
        }
    }

    @Composable
    fun IconExample() {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(Icons.Default.Home, contentDescription = "Home Icon")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Home")
        }
    }

    @Composable
    fun ProgressBarExample() {
        var progress by remember { mutableStateOf(0.5f) }

        Column(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator(progress = progress)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { progress += 0.1f }) {
                Text("Increase Progress")
            }
        }
    }

    @Composable
    fun RadioButtonExample() {
        var selectedOption by remember { mutableStateOf("Option 1") }

        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                RadioButton(
                    selected = selectedOption == "Option 1",
                    onClick = { selectedOption = "Option 1" }
                )
                Text("Option 1")
            }
            Row {
                RadioButton(
                    selected = selectedOption == "Option 2",
                    onClick = { selectedOption = "Option 2" }
                )
                Text("Option 2")
            }
        }
    }

    @Composable
    fun SliderExample() {
        var sliderPosition by remember { mutableStateOf(0.5f) }

        Column(modifier = Modifier.padding(16.dp)) {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it }
            )
            Text("Slider Value: ${sliderPosition * 100}")
        }
    }

    @Composable
    fun SpacerExample() {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Spacer Example")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Spacer Below")
        }
    }

    @Composable
    fun SwitchExample() {
        var checked by remember { mutableStateOf(true) }

        Row(modifier = Modifier.padding(16.dp)) {
            Switch(
                checked = checked,
                onCheckedChange = { checked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(if (checked) "ON" else "OFF")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBarExample() {
        TopAppBar(
            title = { Text("Top App Bar") },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun BottomNavigationExample() {
        var selectedItem by remember { mutableStateOf(0) }
        val items = listOf("Home", "Search", "Profile")
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Person)

        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(icons[index], contentDescription = item) },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }
    @Composable
    fun DialogExample() {
        var showDialog by remember { mutableStateOf(false) }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Dialog Title") },
                text = { Text("This is an example of a Dialog.") },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }
    }

    @Composable
    fun DividerExample() {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Above Divider")
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text("Below Divider")
        }
    }

    @Composable
    fun DropDownMenuExample() {
        var expanded by remember { mutableStateOf(false) }
        val items = listOf("Item 1", "Item 2", "Item 3")
        var selectedIndex by remember { mutableStateOf(0) }

        Box(modifier = Modifier.padding(16.dp)) {
            Button(onClick = { expanded = true }) {
                Text(items[selectedIndex])
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEachIndexed { index, s ->
                    DropdownMenuItem(
                        text = { Text(s) },
                        onClick = {
                            selectedIndex = index
                            expanded = false
                        }
                    )
                }
            }
        }
    }


    @Composable
    fun LazyVerticalGridExample() {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp)
        ) {
            items(10) { index ->
                Text("Item #$index", modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun NavigationRailExample() {
        var selectedItem by remember { mutableStateOf(0) }
        val items = listOf("Home", "Search", "Profile")

        NavigationRail {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    icon = {},
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }

    @Composable
    fun OutlinedTextFieldExample() {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text") },
            modifier = Modifier.padding(16.dp)
        )
    }

    @Composable
    fun PagerExample() {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Pager Example")
            // Aquí podrías agregar tu lógica para un Pager si fuera necesario
        }
    }

    @Composable
    fun SnackbarExample() {
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        Column(modifier = Modifier.padding(16.dp)) {
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("This is a Snackbar")
                }
            }) {
                Text("Show Snackbar")
            }

            SnackbarHost(hostState = snackbarHostState)
        }
    }

    @Composable
    fun TabRowExample() {
        var selectedTabIndex by remember { mutableStateOf(0) }
        val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

        Column(modifier = Modifier.padding(16.dp)) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        text = { Text(tab) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> Text("Content for Tab 1")
                1 -> Text("Content for Tab 2")
                2 -> Text("Content for Tab 3")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ScaffoldExample()
    }
}
