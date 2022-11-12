import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)
object NavigationBar {
    val nav = listOf(
       NavItem(
           label = "Settings",
           // TODO: icon = <icon-goes-here>
           route = "Sample"
       ),
       NavItem(
           label = "Schedule",
            // TODO: icon = <icon-goes-here>
            route = "Sample2"
    )
    )
}