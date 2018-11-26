public class ReadFactory {

    public iReader get(FileType fileType){
        switch (fileType){
            case JSON:
                return new JsonReader();
            case XML:
                return new XMLReader();
        }
        return null;
    }

    public enum FileType {
        JSON,
        XML
    }

}
