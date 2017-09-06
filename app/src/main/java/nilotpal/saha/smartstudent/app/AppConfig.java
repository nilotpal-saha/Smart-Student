package nilotpal.saha.smartstudent.app;

public class AppConfig {
	// Server user login url
	public static String URL_LOGIN = "http://192.168.0.4/smart-student/android_login_api/login.php";

	// Server user register url
	public static String URL_REGISTER = "http://192.168.0.4/smart-student/android_login_api/register.php";

	//Server notification Rest API
	public static final String URL_NOTIFICATION = "http://192.168.0.4/smart-student/smartfs/notification.php";

	//Server event Rest API
	public static final String URL_EVENT = "http://192.168.0.4/smart-student/smartfs/event.php";

	//Server forum Rest API
	public static final String URL_FORUM = "http://192.168.0.4/smart-student/smartfs/forum.php";

	//Server update to forum Rest API
	public static final String URL_FORUM_UPDATE = "http://192.168.0.4/smart-student/smartfs/update-forum.php";
}
