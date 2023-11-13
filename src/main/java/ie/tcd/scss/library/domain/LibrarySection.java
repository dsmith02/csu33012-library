package ie.tcd.scss.library.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class LibrarySection
{
    @Id
    private String code;
    @Column
    private String name;

    public LibrarySection(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    protected LibrarySection()
    {
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibrarySection that = (LibrarySection) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(code, name);
    }

    @Override
    public String toString()
    {
        return "LibrarySection{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}