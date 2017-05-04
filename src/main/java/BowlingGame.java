public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int[] pointPerball = new int[22];
        int[] pointPerFrame = new int[10];
        int score = 0;
        String point;
        int ballCount = 0;
        for (int i = 0; i < bowlingCode.length(); i++) { // determine the points each ball earns
            point = bowlingCode.substring(i, i + 1);
            if(point.equals("|"))
                continue;
            else if (point.equals("X")) {
                pointPerball[ballCount++] = 10;
                if (ballCount < 20)
                    pointPerball[ballCount++] = 0;
            } else if (point.equals("-")) {
                pointPerball[ballCount++] = 0;
            } else if (point.equals("/")) {
                pointPerball[ballCount++] = 10;
            } else pointPerball[ballCount++] = Integer.parseInt(point);
        }
        ballCount = 0;
        for (int i = 0; i < bowlingCode.length(); i++) { // calculate total score
            point = bowlingCode.substring(i, i + 1);
            if(point.equals("|"))
                continue;
            else if (point.equals("X")) {
                if (ballCount < 20) {
                    if (pointPerball[ballCount + 2] == 10 && pointPerball[ballCount + 3] == 0)
                        score += pointPerball[ballCount] + pointPerball[ballCount + 2] + pointPerball[ballCount + 4];
                    else    score += pointPerball[ballCount] + pointPerball[ballCount + 2] + pointPerball[ballCount + 3];
                    ballCount += 2;
                }
            } else if (point.equals("-")) {
                ballCount++;
            } else if (point.equals("/")) {
                score += pointPerball[ballCount] + pointPerball[ballCount + 1];
                ballCount++;
            } else if (i < bowlingCode.length() - 2 && !bowlingCode.substring(i + 1, i + 2).equals("/")) {
                score += Integer.parseInt(point);
                ballCount++;
            } else ballCount++;
        }
        return score;
    }
}
