package com.simbirsoft.con_calc.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_floor")
public class Floor extends AbstractElement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Double height;
    private Double square;
    private Integer overWidth;
    private Integer outWallWidth;
    private Integer inWallWidth;
    private Boolean isFirst;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WallCladding> wallCladdings;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hole> holes;

    @OneToOne(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FloorResults floorResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frame_id", referencedColumnName = "id")
    private Frame frame;

    public Floor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getOverWidth() {
        return overWidth;
    }

    public void setOverWidth(Integer overWidth) {
        this.overWidth = overWidth;
    }

    public Integer getOutWallWidth() {
        return outWallWidth;
    }

    public void setOutWallWidth(Integer outWallWidth) {
        this.outWallWidth = outWallWidth;
    }

    public Integer getInWallWidth() {
        return inWallWidth;
    }

    public void setInWallWidth(Integer inWallWidth) {
        this.inWallWidth = inWallWidth;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Set<WallCladding> getWallCladdings() {
        return wallCladdings;
    }

    public void setWallCladdings(Set<WallCladding> wallCladdings) {
        this.wallCladdings = wallCladdings;
    }

    public Set<Hole> getHoles() {
        return holes;
    }

    public void setHoles(Set<Hole> holes) {
        this.holes = holes;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public FloorResults getFloorResults() {
        return floorResults;
    }

    public void setFloorResults(FloorResults floorResults) {
        this.floorResults = floorResults;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }


}
