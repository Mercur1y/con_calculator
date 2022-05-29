package com.simbirsoft.con_calc.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_foundation")
public class Foundation extends AbstractElement{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "foundation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WallCladding> wallCladdings;

    @OneToOne(mappedBy = "foundation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FoundationResults foundationResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frame_id", referencedColumnName = "id")
    private Frame frame;

    public Foundation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<WallCladding> getWallCladdings() {
        return wallCladdings;
    }

    public void setWallCladdings(Set<WallCladding> wallCladdings) {
        this.wallCladdings = wallCladdings;
    }

    public FoundationResults getFoundationResults() {
        return foundationResults;
    }

    public void setFoundationResults(FoundationResults foundationResults) {
        this.foundationResults = foundationResults;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
