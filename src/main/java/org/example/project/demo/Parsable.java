package org.example.project.demo;

/**
 * @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra
 * <p>
 * Tai yra  interfeisas, kurį turi tenkinti KTU studentų kuriamos duomenų klasės
 * Metodai užtikrina patogų duomenų suformavimą iš String eilučių
 ******************************************************************************/
public interface Parsable<T> {

    /**
     * Suformuoja objektą iš teksto eilutės
     *
     * @param dataString
     */
    void parse(String dataString);
}
