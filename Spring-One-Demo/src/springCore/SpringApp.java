package springCore;

public class SpringApp {

		public static void main(String[] args)
		{
			ICoach theCoach=new TrackCoach();
			System.out.println(theCoach.DailyWorkOut());
			
		}
}
