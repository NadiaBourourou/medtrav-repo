package featuresDomain.chat;

import com.skype.Skype;
import com.skype.SkypeException;

public class MakeCall {
	public static void main(String[] args) {
		try {
			Skype.call(Constants.SKYPE_FRIEND_NICKNAME);
		} catch (SkypeException e) {
			e.printStackTrace();
		}
	}

}
