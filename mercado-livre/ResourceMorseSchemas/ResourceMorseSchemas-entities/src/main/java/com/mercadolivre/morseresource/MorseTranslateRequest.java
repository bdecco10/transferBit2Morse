//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2020.08.19 às 09:41:28 PM BRT 
//


package com.mercadolivre.morseresource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="morseTranslate" type="{http://mercadolivre.com/morseResource}MorseHuman"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "morseTranslate"
})
@XmlRootElement(name = "MorseTranslateRequest")
public class MorseTranslateRequest {

    @XmlElement(required = true)
    protected MorseHuman morseTranslate;

    /**
     * Obtém o valor da propriedade morseTranslate.
     * 
     * @return
     *     possible object is
     *     {@link MorseHuman }
     *     
     */
    public MorseHuman getMorseTranslate() {
        return morseTranslate;
    }

    /**
     * Define o valor da propriedade morseTranslate.
     * 
     * @param value
     *     allowed object is
     *     {@link MorseHuman }
     *     
     */
    public void setMorseTranslate(MorseHuman value) {
        this.morseTranslate = value;
    }

}
