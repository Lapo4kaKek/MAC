import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
// класс для вывода результатов работы этого демона
public class JsonLogger {
    private static final Logger logger = LogManager.getLogger(JsonLogger.class);

    public void addStringToJsonFile(String str) {
        logger.info("I like ???");
        logger.error("ASFSDfdsf df dsf ");
    }
}
