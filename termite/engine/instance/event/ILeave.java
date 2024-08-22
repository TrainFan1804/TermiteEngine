package engine.instance.event;

/**
 * @author                              o.le
 * @version                             1.0
 * @since                               0.24
 * @deprecated                          This type isn't necessary anymore because
 *                                      the engine will handle the {@code LEAVE} 
 *                                      event now.
 */
@Deprecated(since = "0.29")
interface ILeave {

    void leave();
}
