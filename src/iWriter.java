/**
 * Interface to decide which strategy to use, XML or JSON
 */
public interface iWriter {
    /**
     * @param tripData holds the trip to be saved
     * @param fileName holds the name to save the file as
     */
    public void Write(Trip tripData, String fileName);
}
