public class WriteFactory {

    public iWriter get(FileType fileType){
        switch (fileType){
            case JSON:
                return new JsonWriter();
            case XML:
                return new XMLWriter();
        }
        return null;
    }

    public enum FileType {
        JSON,
        XML
    }
}
