/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.acme.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Twittr extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2684508200960077792L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Twittr\",\"namespace\":\"com.acme.avro\",\"fields\":[{\"name\":\"data\",\"type\":{\"type\":\"record\",\"name\":\"data\",\"fields\":[{\"name\":\"author_id\",\"type\":\"string\"},{\"name\":\"context_annotations\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"context_annotations_record\",\"fields\":[{\"name\":\"domain\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"domain\",\"fields\":[{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"default\":\"null\"},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":\"null\"},{\"name\":\"description\",\"type\":[\"null\",\"string\"],\"default\":\"null\"}]}]},{\"name\":\"entity\",\"type\":{\"type\":\"record\",\"name\":\"entity\",\"fields\":[{\"name\":\"id\",\"type\":[\"null\",\"string\"]},{\"name\":\"name\",\"type\":[\"null\",\"string\"]}]}}]}}},{\"name\":\"conversation_id\",\"type\":\"string\"},{\"name\":\"created_at\",\"type\":\"string\",\"logicalType\":\"date\"},{\"name\":\"entities\",\"type\":{\"type\":\"record\",\"name\":\"entities\",\"fields\":[{\"name\":\"hashtags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"hashtags_record\",\"fields\":[{\"name\":\"start\",\"type\":[\"null\",\"int\"],\"default\":\"null\"},{\"name\":\"end\",\"type\":[\"null\",\"int\"],\"default\":\"null\"},{\"name\":\"tag\",\"type\":[\"null\",\"string\"],\"default\":\"null\"}]}}},{\"name\":\"mentions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"mentions_record\",\"fields\":[{\"name\":\"start\",\"type\":\"int\"},{\"name\":\"end\",\"type\":\"int\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"string\"}]}}}]}},{\"name\":\"geo\",\"type\":{\"type\":\"record\",\"name\":\"geo\",\"fields\":[]}},{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"lang\",\"type\":\"string\"},{\"name\":\"possibly_sensitive\",\"type\":\"boolean\"},{\"name\":\"public_metrics\",\"type\":{\"type\":\"record\",\"name\":\"public_metrics\",\"fields\":[{\"name\":\"retweet_count\",\"type\":\"int\"},{\"name\":\"reply_count\",\"type\":\"int\"},{\"name\":\"like_count\",\"type\":\"int\"},{\"name\":\"quote_count\",\"type\":\"int\"}]}},{\"name\":\"referenced_tweets\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"referenced_tweets_record\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"string\"}]}}},{\"name\":\"reply_settings\",\"type\":\"string\"},{\"name\":\"source\",\"type\":\"string\"},{\"name\":\"text\",\"type\":\"string\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.acme.avro.data data;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Twittr() {}

  /**
   * All-args constructor.
   * @param data The new value for data
   */
  public Twittr(com.acme.avro.data data) {
    this.data = data;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return data;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: data = (com.acme.avro.data)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'data' field.
   * @return The value of the 'data' field.
   */
  public com.acme.avro.data getData() {
    return data;
  }

  /**
   * Sets the value of the 'data' field.
   * @param value the value to set.
   */
  public void setData(com.acme.avro.data value) {
    this.data = value;
  }

  /**
   * Creates a new Twittr RecordBuilder.
   * @return A new Twittr RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new Twittr RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Twittr RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new Twittr RecordBuilder by copying an existing Twittr instance.
   * @param other The existing instance to copy.
   * @return A new Twittr RecordBuilder
   */
  public static Builder newBuilder(Twittr other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for Twittr instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Twittr>
    implements org.apache.avro.data.RecordBuilder<Twittr> {

    private com.acme.avro.data data;
    private com.acme.avro.data.Builder dataBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.data)) {
        this.data = data().deepCopy(fields()[0].schema(), other.data);
        fieldSetFlags()[0] = true;
      }
      if (other.hasDataBuilder()) {
        this.dataBuilder = com.acme.avro.data.newBuilder(other.getDataBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing Twittr instance
     * @param other The existing instance to copy.
     */
    private Builder(Twittr other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.data)) {
        this.data = data().deepCopy(fields()[0].schema(), other.data);
        fieldSetFlags()[0] = true;
      }
      this.dataBuilder = null;
    }

    /**
      * Gets the value of the 'data' field.
      * @return The value.
      */
    public com.acme.avro.data getData() {
      return data;
    }

    /**
      * Sets the value of the 'data' field.
      * @param value The value of 'data'.
      * @return This builder.
      */
    public Builder setData(com.acme.avro.data value) {
      validate(fields()[0], value);
      this.dataBuilder = null;
      this.data = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'data' field has been set.
      * @return True if the 'data' field has been set, false otherwise.
      */
    public boolean hasData() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'data' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.acme.avro.data.Builder getDataBuilder() {
      if (dataBuilder == null) {
        if (hasData()) {
          setDataBuilder(com.acme.avro.data.newBuilder(data));
        } else {
          setDataBuilder(com.acme.avro.data.newBuilder());
        }
      }
      return dataBuilder;
    }

    /**
     * Sets the Builder instance for the 'data' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public Builder setDataBuilder(com.acme.avro.data.Builder value) {
      clearData();
      dataBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'data' field has an active Builder instance
     * @return True if the 'data' field has an active Builder instance
     */
    public boolean hasDataBuilder() {
      return dataBuilder != null;
    }

    /**
      * Clears the value of the 'data' field.
      * @return This builder.
      */
    public Builder clearData() {
      data = null;
      dataBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public Twittr build() {
      try {
        Twittr record = new Twittr();
        if (dataBuilder != null) {
          record.data = this.dataBuilder.build();
        } else {
          record.data = fieldSetFlags()[0] ? this.data : (com.acme.avro.data) defaultValue(fields()[0]);
        }
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
