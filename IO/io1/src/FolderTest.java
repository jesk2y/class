import java.io.File;

public class FolderTest {

    public static void main(String[] args) {

        File folder = new File("C:\\zzz\\img"); // 디렉토리 관련 정보가 folder에 저장

        String[] fileNames = folder.list(); // 리스트 함수를 사용해 folder에 저장되어있는 정보를 String으로 출력

        for (String fileName:fileNames) {
            System.out.println(fileName);
        }
        int idx = (int)(Math.random() * fileNames.length);
        System.out.println(idx);    // 랜덤값 하나 출력

    }
}
