package com.designpattern.thothDemo;

public interface IThothResponse<T extends IThothValidator> {
    public void accept(T t);
}
