/**
 * Interface to decide which strategy to use to read, XML or JSON
 */
public interface iReader {
    /**
     * @preturn Trip trip being loaded
     * @param fileName holds the name of the file to read
     */
    public Trip Read(String fileName);
}
