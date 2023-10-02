package demo.xdemo.tree.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import demo.xdemo.tree.TreeModel;
import demo.xdemo.tree.builder.TreeModelBuilder;

public class TreeConverter implements Converter {

  private static final String CONTAINER_TAG = "container";

  private static final String DOCUMENT_TAG = "document";

  @Override
  public boolean canConvert(Class type) {
    return TreeModel.class.isAssignableFrom(type);
  }

  @Override
  public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    TreeModel tree = (TreeModel) source;
    for (String container : tree.getContainers()){
      marshalString(writer, CONTAINER_TAG, container);
    }

    for (String document : tree.getDocuments()) {
      marshalString(writer, DOCUMENT_TAG, document);
    }
  }

  @Override
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    TreeModelBuilder builder = new TreeModelBuilder();
    while (reader.hasMoreChildren()) {
      reader.moveDown();

      String childKind = reader.getNodeName();
      String childName = reader.getValue();
      switch (childKind) {
        case CONTAINER_TAG:
          builder.addContainer(childName);
          break;
        case DOCUMENT_TAG:
          builder.addDocument(childName);
          break;
        default:
          builder.addUnexpected(childName);
      }

      reader.moveUp();
    }
    return builder.build();
  }

  private void marshalString(HierarchicalStreamWriter writer, String tag, String value) {
    writer.startNode(tag);
    writer.setValue(value);
    writer.endNode();
  }
}
