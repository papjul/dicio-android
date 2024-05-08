package org.dicio.skill.chain

import org.dicio.skill.SkillComponent
import org.dicio.skill.util.CleanableUp

/**
 * Processes the data from the previous step of computation to produce a result to be passed to the
 * next step. It is made for intermediate calculations, to connect to the internet and extract
 * things, etc. It should not be used to perform platform-specific actions.
 * Even though everything could be done in an [InputRecognizer], it is better to keep things
 * separate, so that [InputRecognizer]'s only purpose is to collect information from user
 * input. Also, an [IntermediateProcessor] is allowed to throw exceptions, while it is not
 * possible in an [InputRecognizer].
 * @param FromType the type of the data from the previous step of computation (i.e. the input)
 * @param ResultType the type of the processed and returned data (i.e. the output)
 */
abstract class IntermediateProcessor<FromType, ResultType> : SkillComponent() {
    /**
     * Processes the data obtained from the previous step to produce a result to be passed to the
     * next step. To be used to make calculations, to connect to the internet and extract things,
     * etc. It should not be used to perform platform-specific actions and should not store any
     * temporary data inside the object (that's why it does not extend [CleanableUp]).
     *
     * @param data the data to process, from the previous step
     * @return the result of the data processing
     */
    @Throws(Exception::class)
    abstract fun process(data: FromType): ResultType
}
