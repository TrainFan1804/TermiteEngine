package de.o.le.termite.application.dto.trans;

/**
 * Generic <b>Trans</b>mission context for the communication between backend and frontend.
 * Is used inside the backend to wrap the payload efficient.
 * <p>
 *     Examples for implementations are found in this package.
 * </p>
 *
 * @author                              o.le
 * @version                             1.0
 * @since                               26.01.14
 */
public interface TransContext {
    void accept(TransContextVisitor visitor);
}
