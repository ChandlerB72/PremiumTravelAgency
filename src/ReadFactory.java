/**
 * Responsible for read object creation
 */
public class ReadFactory {

    /**
     * @param fileType type of file to be read
     * @return iReader based off fileType
     */
    public iReader get(FileType fileType){
        switch (fileType){
            case JSON:
                return new JsonReader();
            case XML:
                return new XMLReader();
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
