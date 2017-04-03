/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package by.bsuir.Shaliov.common.model;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-03-17")
public class Book implements org.apache.thrift.TBase<Book, Book._Fields>, java.io.Serializable, Cloneable, Comparable<Book> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Book");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BOOK_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("bookName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField AUTHOR_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("authorName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PAGE_VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageValue", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BookStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BookTupleSchemeFactory();

  public int id; // required
  public java.lang.String bookName; // required
  public java.lang.String authorName; // required
  public int pageValue; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    BOOK_NAME((short)2, "bookName"),
    AUTHOR_NAME((short)3, "authorName"),
    PAGE_VALUE((short)4, "pageValue");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // BOOK_NAME
          return BOOK_NAME;
        case 3: // AUTHOR_NAME
          return AUTHOR_NAME;
        case 4: // PAGE_VALUE
          return PAGE_VALUE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __PAGEVALUE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BOOK_NAME, new org.apache.thrift.meta_data.FieldMetaData("bookName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUTHOR_NAME, new org.apache.thrift.meta_data.FieldMetaData("authorName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PAGE_VALUE, new org.apache.thrift.meta_data.FieldMetaData("pageValue", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Book.class, metaDataMap);
  }

  public Book() {
  }

  public Book(
    int id,
    java.lang.String bookName,
    java.lang.String authorName,
    int pageValue)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.bookName = bookName;
    this.authorName = authorName;
    this.pageValue = pageValue;
    setPageValueIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Book(Book other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetBookName()) {
      this.bookName = other.bookName;
    }
    if (other.isSetAuthorName()) {
      this.authorName = other.authorName;
    }
    this.pageValue = other.pageValue;
  }

  public Book deepCopy() {
    return new Book(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.bookName = null;
    this.authorName = null;
    setPageValueIsSet(false);
    this.pageValue = 0;
  }

  public int getId() {
    return this.id;
  }

  public Book setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public java.lang.String getBookName() {
    return this.bookName;
  }

  public Book setBookName(java.lang.String bookName) {
    this.bookName = bookName;
    return this;
  }

  public void unsetBookName() {
    this.bookName = null;
  }

  /** Returns true if field bookName is set (has been assigned a value) and false otherwise */
  public boolean isSetBookName() {
    return this.bookName != null;
  }

  public void setBookNameIsSet(boolean value) {
    if (!value) {
      this.bookName = null;
    }
  }

  public java.lang.String getAuthorName() {
    return this.authorName;
  }

  public Book setAuthorName(java.lang.String authorName) {
    this.authorName = authorName;
    return this;
  }

  public void unsetAuthorName() {
    this.authorName = null;
  }

  /** Returns true if field authorName is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthorName() {
    return this.authorName != null;
  }

  public void setAuthorNameIsSet(boolean value) {
    if (!value) {
      this.authorName = null;
    }
  }

  public int getPageValue() {
    return this.pageValue;
  }

  public Book setPageValue(int pageValue) {
    this.pageValue = pageValue;
    setPageValueIsSet(true);
    return this;
  }

  public void unsetPageValue() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PAGEVALUE_ISSET_ID);
  }

  /** Returns true if field pageValue is set (has been assigned a value) and false otherwise */
  public boolean isSetPageValue() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PAGEVALUE_ISSET_ID);
  }

  public void setPageValueIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PAGEVALUE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Integer)value);
      }
      break;

    case BOOK_NAME:
      if (value == null) {
        unsetBookName();
      } else {
        setBookName((java.lang.String)value);
      }
      break;

    case AUTHOR_NAME:
      if (value == null) {
        unsetAuthorName();
      } else {
        setAuthorName((java.lang.String)value);
      }
      break;

    case PAGE_VALUE:
      if (value == null) {
        unsetPageValue();
      } else {
        setPageValue((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case BOOK_NAME:
      return getBookName();

    case AUTHOR_NAME:
      return getAuthorName();

    case PAGE_VALUE:
      return getPageValue();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case BOOK_NAME:
      return isSetBookName();
    case AUTHOR_NAME:
      return isSetAuthorName();
    case PAGE_VALUE:
      return isSetPageValue();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Book)
      return this.equals((Book)that);
    return false;
  }

  public boolean equals(Book that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_bookName = true && this.isSetBookName();
    boolean that_present_bookName = true && that.isSetBookName();
    if (this_present_bookName || that_present_bookName) {
      if (!(this_present_bookName && that_present_bookName))
        return false;
      if (!this.bookName.equals(that.bookName))
        return false;
    }

    boolean this_present_authorName = true && this.isSetAuthorName();
    boolean that_present_authorName = true && that.isSetAuthorName();
    if (this_present_authorName || that_present_authorName) {
      if (!(this_present_authorName && that_present_authorName))
        return false;
      if (!this.authorName.equals(that.authorName))
        return false;
    }

    boolean this_present_pageValue = true;
    boolean that_present_pageValue = true;
    if (this_present_pageValue || that_present_pageValue) {
      if (!(this_present_pageValue && that_present_pageValue))
        return false;
      if (this.pageValue != that.pageValue)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + ((isSetBookName()) ? 131071 : 524287);
    if (isSetBookName())
      hashCode = hashCode * 8191 + bookName.hashCode();

    hashCode = hashCode * 8191 + ((isSetAuthorName()) ? 131071 : 524287);
    if (isSetAuthorName())
      hashCode = hashCode * 8191 + authorName.hashCode();

    hashCode = hashCode * 8191 + pageValue;

    return hashCode;
  }

  @Override
  public int compareTo(Book other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBookName()).compareTo(other.isSetBookName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBookName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bookName, other.bookName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAuthorName()).compareTo(other.isSetAuthorName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthorName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.authorName, other.authorName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPageValue()).compareTo(other.isSetPageValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageValue, other.pageValue);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Book(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bookName:");
    if (this.bookName == null) {
      sb.append("null");
    } else {
      sb.append(this.bookName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("authorName:");
    if (this.authorName == null) {
      sb.append("null");
    } else {
      sb.append(this.authorName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageValue:");
    sb.append(this.pageValue);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BookStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BookStandardScheme getScheme() {
      return new BookStandardScheme();
    }
  }

  private static class BookStandardScheme extends org.apache.thrift.scheme.StandardScheme<Book> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BOOK_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.bookName = iprot.readString();
              struct.setBookNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTHOR_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.authorName = iprot.readString();
              struct.setAuthorNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PAGE_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageValue = iprot.readI32();
              struct.setPageValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Book struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      if (struct.bookName != null) {
        oprot.writeFieldBegin(BOOK_NAME_FIELD_DESC);
        oprot.writeString(struct.bookName);
        oprot.writeFieldEnd();
      }
      if (struct.authorName != null) {
        oprot.writeFieldBegin(AUTHOR_NAME_FIELD_DESC);
        oprot.writeString(struct.authorName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PAGE_VALUE_FIELD_DESC);
      oprot.writeI32(struct.pageValue);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BookTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BookTupleScheme getScheme() {
      return new BookTupleScheme();
    }
  }

  private static class BookTupleScheme extends org.apache.thrift.scheme.TupleScheme<Book> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetBookName()) {
        optionals.set(1);
      }
      if (struct.isSetAuthorName()) {
        optionals.set(2);
      }
      if (struct.isSetPageValue()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetBookName()) {
        oprot.writeString(struct.bookName);
      }
      if (struct.isSetAuthorName()) {
        oprot.writeString(struct.authorName);
      }
      if (struct.isSetPageValue()) {
        oprot.writeI32(struct.pageValue);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Book struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.bookName = iprot.readString();
        struct.setBookNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.authorName = iprot.readString();
        struct.setAuthorNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.pageValue = iprot.readI32();
        struct.setPageValueIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

