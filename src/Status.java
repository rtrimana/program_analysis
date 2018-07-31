import soot.tagkit.AttributeValueException;
import soot.tagkit.Tag;

/** Class Status is a class the tag implementation for a custom 
 *  tag employed in the Buster algorithm
 * 
 *
 * @author      Joel Bandi <jbandi @ uci.edu>
 * @version     1.0
 * @since       2016-10-02
 */

public class Status implements Tag {

    private String status;

    public Status(String status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return this.status;
    }

    @Override
    public byte[] getValue() throws AttributeValueException {
        return this.status.getBytes();
    }
    
}