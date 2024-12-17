package com.example.composetest101.compose.test113

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest101.R
import com.example.composetest101.compose.test102.ui.theme.ComposeTest101Theme


/**
 * https://developer.android.com/codelabs/jetpack-compose-theming#0
 * https://developer.android.com/codelabs/jetpack-compose-state#0
 * https://www.youtube.com/watch?v=PMMY23F0CFg
 *
 * https://developer.android.com/courses/jetpack-compose/course
 *
 * https://developer.android.com/codelabs/jetpack-compose-layouts#0
 * https://www.youtube.com/watch?v=kyH01Lg4G1E
 */
class Compose113Activity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            MySootheAppWindow(windowSizeClass = windowSizeClass)
        }
    }
}


// Step: MySoothe App
@Composable
fun MySootheApp() {
    // Implement composable here
    HomeScreen()
}

/** SearchBar Start ****************************************/
@Composable
private fun SearchBar(modifier: Modifier = Modifier) {
    TextField(value = "",
        onValueChange = {},
        modifier = modifier
            .heightIn(min = 56.dp)
            .padding(16.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = ""
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = stringResource(R.string.placeholder_search))
        })
}

@Preview(showBackground = true)
@Composable
fun ShowPreviewOfSearchBar() {
    SearchBar()
}
/** SearchBar End ****************************************/


/** AlignYourBodyElement Start ****************************************/
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int = R.drawable.ab1_inversions,
    @StringRes text: Int = R.string.ab1_inversions,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfAlignYourBodyElement() {
    AlignYourBodyElement(modifier = Modifier.padding(8.dp))
}
/** AlignYourBodyElement end ****************************************/

/** FavoriteCollectionCard Start ****************************************/
@Composable
fun FavoriteCollectionCard(
    @DrawableRes image: Int = R.drawable.fc2_nature_meditations,
    @StringRes text: Int = R.string.fc2_nature_meditations,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            modifier = modifier.width(255.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfFavoriteCollectionCard() {
    Surface(modifier = Modifier.padding(8.dp)) {
        FavoriteCollectionCard()
    }
}
/** FavoriteCollectionCard end ****************************************/

/** AlignYourBodyRow Start ****************************************/
@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfAlignYourBodyRow() {
    Surface(modifier = Modifier.padding(8.dp)) {
        AlignYourBodyRow()
    }
}
/** AlignYourBodyRow end ****************************************/


/** FavoriteCollectionsGrid Start ****************************************/
@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(168.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfFavoriteCollectionsGrid() {
    FavoriteCollectionsGrid(modifier = Modifier.padding(8.dp))
}
/** FavoriteCollectionsGrid end ****************************************/


/** HomeSection Start ****************************************/
@Composable
fun HomeSection(
    @StringRes title: Int, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Column(modifier) {
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = modifier.height(16.dp))
        content()
        Spacer(modifier = modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfHomeSection() {
    Surface(modifier = Modifier.padding(8.dp)) {
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}
/** HomeSection end ****************************************/

/** HomeScreen end ****************************************/
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = modifier.height(16.dp))

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfHomeScreen() {
    HomeScreen()
}

/** HomeScreen end ****************************************/

/** SootheBottomNavigation Start ****************************************/
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier, containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(icon = {
            Icon(imageVector = Icons.Default.Spa, contentDescription = null)
        }, label = { Text(text = "Home") }, selected = true, onClick = {})
        NavigationBarItem(icon = {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }, label = { Text(text = "Profile") }, selected = false, onClick = {})
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfSootheBottomNavigation() {
    Surface(modifier = Modifier.padding(8.dp)) {
        SootheBottomNavigation()
    }
}
/** SootheBottomNavigation end ****************************************/


/** MySootheAppPortrait Start ****************************************/
@Composable
fun MySootheAppPortrait(modifier: Modifier = Modifier) {
    ComposeTest101Theme {
        Scaffold(bottomBar = {
            SootheBottomNavigation()
        }) { padding ->
            HomeScreen(modifier = modifier.padding())
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfMySootheAppPortrait() {
    Surface(modifier = Modifier.padding(8.dp)) {
        MySootheAppPortrait()
    }
}
/** MySootheAppPortrait end ****************************************/


/** SootheNavigationRail Start ****************************************/
@Composable
fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NavigationRailItem(icon = {
                Icon(imageVector = Icons.Default.Spa, contentDescription = null)
            }, label = { Text(text = "Home") }, selected = true, onClick = {})
            NavigationRailItem(icon = {
                Icon(imageVector = Icons.Default.Spa, contentDescription = null)
            }, label = { Text(text = "Profile") }, selected = false, onClick = {})
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ShowPreviewOfSootheNavigationRail() {
    Surface(modifier = Modifier.padding(8.dp)) {
        SootheNavigationRail()
    }
}
/** SootheNavigationRail end ****************************************/


/** MySootheAppLandscape Start ****************************************/
@Composable
fun MySootheAppLandscape(modifier: Modifier = Modifier) {
    ComposeTest101Theme {
        Row {
            SootheNavigationRail()
            HomeScreen()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE,
    heightDp = 400, widthDp = 800)
@Composable
fun ShowPreviewOfMySootheAppLandscape() {
    Surface(modifier = Modifier.padding(8.dp)) {
        MySootheAppLandscape()
    }
}
/** MySootheAppLandscape end ****************************************/


/** MySootheApp Start ****************************************/
@Composable
fun MySootheAppWindow(modifier: Modifier = Modifier, windowSizeClass: WindowSizeClass) {
    when(windowSizeClass.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }
        WindowWidthSizeClass.Expanded ->{
            MySootheAppLandscape()
        }
    }
}

/** MySootheApp end ****************************************/


private data class DrawableStringPair(
    @DrawableRes val drawable: Int, @StringRes val text: Int
)

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }
