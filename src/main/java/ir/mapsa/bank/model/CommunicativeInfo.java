package ir.mapsa.bank.model;

import ir.mapsa.bank.model.enums.CommunicativeTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Embeddable
public class CommunicativeInfo {

    @Column(name = "TYPE_OF_COMMUNICATIVE")
    @Enumerated(EnumType.STRING)
    private CommunicativeTypes communicativeTypes;


    @ElementCollection
    private List<String> communicativeTypesPaths=new ArrayList<>();


    public CommunicativeTypes getCommunicativeTypes() {
        return communicativeTypes;
    }

    public CommunicativeInfo setCommunicativeTypes(CommunicativeTypes communicativeTypes) {
        this.communicativeTypes = communicativeTypes;
        return this;
    }

    public List<String> getCommunicativeTypesPaths() {
        return communicativeTypesPaths;
    }

    public CommunicativeInfo setCommunicativeTypesPaths(List<String> communicativeTypesPaths) {
        this.communicativeTypesPaths = communicativeTypesPaths;
        return this;
    }
}
