/**
 * I could make the fields in the classes {@link Dialogue}, {@link DialogueNode}
 * and {@link PlayerResponse} public and remove the getter because those are
 * only store values from a JSON file. And the JSON reader use reflection to
 * access those file anyway. But I don't want to change this yet because I am
 * lazy af.
 * <p>
 * I defeated the lazy bear and made the field public..
 */
package engine.instance.dialog;
