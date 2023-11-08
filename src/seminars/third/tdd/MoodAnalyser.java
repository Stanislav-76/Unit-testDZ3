package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("отличный")) {
            return "happy";
        } else if (message.contains("ужасный")) {
            return "bad";
        }
        return "so so";
    }

}