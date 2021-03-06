/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.acme.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class entities extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5431059292469169257L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"entities\",\"namespace\":\"com.acme.avro\",\"fields\":[{\"name\":\"hashtags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"hashtags_record\",\"fields\":[{\"name\":\"start\",\"type\":[\"null\",\"int\"],\"default\":\"null\"},{\"name\":\"end\",\"type\":[\"null\",\"int\"],\"default\":\"null\"},{\"name\":\"tag\",\"type\":[\"null\",\"string\"],\"default\":\"null\"}]}}},{\"name\":\"mentions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"mentions_record\",\"fields\":[{\"name\":\"start\",\"type\":\"int\"},{\"name\":\"end\",\"type\":\"int\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"string\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<hashtags_record> hashtags;
  @Deprecated public java.util.List<mentions_record> mentions;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public entities() {}

  /**
   * All-args constructor.
   * @param hashtags The new value for hashtags
   * @param mentions The new value for mentions
   */
  public entities(java.util.List<hashtags_record> hashtags, java.util.List<mentions_record> mentions) {
    this.hashtags = hashtags;
    this.mentions = mentions;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return hashtags;
    case 1: return mentions;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: hashtags = (java.util.List<hashtags_record>)value$; break;
    case 1: mentions = (java.util.List<mentions_record>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'hashtags' field.
   * @return The value of the 'hashtags' field.
   */
  public java.util.List<hashtags_record> getHashtags() {
    return hashtags;
  }

  /**
   * Sets the value of the 'hashtags' field.
   * @param value the value to set.
   */
  public void setHashtags(java.util.List<hashtags_record> value) {
    this.hashtags = value;
  }

  /**
   * Gets the value of the 'mentions' field.
   * @return The value of the 'mentions' field.
   */
  public java.util.List<mentions_record> getMentions() {
    return mentions;
  }

  /**
   * Sets the value of the 'mentions' field.
   * @param value the value to set.
   */
  public void setMentions(java.util.List<mentions_record> value) {
    this.mentions = value;
  }

  /**
   * Creates a new entities RecordBuilder.
   * @return A new entities RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new entities RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new entities RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new entities RecordBuilder by copying an existing entities instance.
   * @param other The existing instance to copy.
   * @return A new entities RecordBuilder
   */
  public static Builder newBuilder(entities other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for entities instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<entities>
    implements org.apache.avro.data.RecordBuilder<entities> {

    private java.util.List<hashtags_record> hashtags;
    private java.util.List<mentions_record> mentions;

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
      if (isValidValue(fields()[0], other.hashtags)) {
        this.hashtags = data().deepCopy(fields()[0].schema(), other.hashtags);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.mentions)) {
        this.mentions = data().deepCopy(fields()[1].schema(), other.mentions);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing entities instance
     * @param other The existing instance to copy.
     */
    private Builder(entities other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.hashtags)) {
        this.hashtags = data().deepCopy(fields()[0].schema(), other.hashtags);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.mentions)) {
        this.mentions = data().deepCopy(fields()[1].schema(), other.mentions);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'hashtags' field.
      * @return The value.
      */
    public java.util.List<hashtags_record> getHashtags() {
      return hashtags;
    }

    /**
      * Sets the value of the 'hashtags' field.
      * @param value The value of 'hashtags'.
      * @return This builder.
      */
    public Builder setHashtags(java.util.List<hashtags_record> value) {
      validate(fields()[0], value);
      this.hashtags = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'hashtags' field has been set.
      * @return True if the 'hashtags' field has been set, false otherwise.
      */
    public boolean hasHashtags() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'hashtags' field.
      * @return This builder.
      */
    public Builder clearHashtags() {
      hashtags = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'mentions' field.
      * @return The value.
      */
    public java.util.List<mentions_record> getMentions() {
      return mentions;
    }

    /**
      * Sets the value of the 'mentions' field.
      * @param value The value of 'mentions'.
      * @return This builder.
      */
    public Builder setMentions(java.util.List<mentions_record> value) {
      validate(fields()[1], value);
      this.mentions = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'mentions' field has been set.
      * @return True if the 'mentions' field has been set, false otherwise.
      */
    public boolean hasMentions() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'mentions' field.
      * @return This builder.
      */
    public Builder clearMentions() {
      mentions = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public entities build() {
      try {
        entities record = new entities();
        record.hashtags = fieldSetFlags()[0] ? this.hashtags : (java.util.List<hashtags_record>) defaultValue(fields()[0]);
        record.mentions = fieldSetFlags()[1] ? this.mentions : (java.util.List<mentions_record>) defaultValue(fields()[1]);
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
