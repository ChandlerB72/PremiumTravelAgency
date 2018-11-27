/**
 * Responsible for write object creation
 */
public class WriteFactory {

    /**
     * @param fileType type of file to save as
     * @return iWriter based off fileType
     */
    public iWriter get(FileType fileType){
        switch (fileType){
            case JSON:
                return new JsonWriter();
            case XML:
                return new XMLWriter();
        }
        return null;
    }

    /**
     * Possible file types
     */
    public enum FileType {
        JSON,
        XML
    }
}
